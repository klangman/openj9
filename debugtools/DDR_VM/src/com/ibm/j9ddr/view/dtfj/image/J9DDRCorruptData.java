/*******************************************************************************
 * Copyright IBM Corp. and others 2009
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] https://openjdk.org/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/
package com.ibm.j9ddr.view.dtfj.image;

import com.ibm.dtfj.image.CorruptData;
import com.ibm.dtfj.image.ImagePointer;
import com.ibm.j9ddr.AddressedCorruptDataException;
import com.ibm.j9ddr.corereaders.memory.IProcess;

/**
 * CorruptData implementation that can bridge the gap between
 * DDR CorruptDataExceptions and DTFJ CorruptData interface
 * 
 * @author andhall
 *
 */
public class J9DDRCorruptData implements CorruptData
{

	private final IProcess proc;
	
	private final com.ibm.j9ddr.CorruptDataException cde;
	
	private final String message;
	private final boolean addressSet;
	private final long address;
	
	public J9DDRCorruptData(IProcess proc, com.ibm.j9ddr.CorruptDataException e)
	{
		this.proc = proc;
		this.message = null;
		this.address = 0;
		this.addressSet = false;
		this.cde = e;
	}

	public J9DDRCorruptData(IProcess proc)
	{
		this.cde = null;
		this.proc = proc;
		this.message = null;
		this.addressSet = false;
		this.address = 0;
	}
	
	public J9DDRCorruptData(IProcess proc, String message)
	{
		this.proc = proc;
		this.cde = null;
		this.message = message;
		this.address = 0;
		this.addressSet = false;
	}
	
	public J9DDRCorruptData(IProcess proc, String message, long address)
	{
		this.proc = proc;
		this.cde = null;
		this.message = message;
		this.address = address;
		this.addressSet = true;
	}

	/* (non-Javadoc)
	 * @see com.ibm.dtfj.image.CorruptData#getAddress()
	 */
	public ImagePointer getAddress()
	{
		if (addressSet) {
			return new J9DDRImagePointer(proc, address);
		} else if (this.cde != null && this.cde instanceof AddressedCorruptDataException) {
			return new J9DDRImagePointer(proc,((AddressedCorruptDataException)cde).getAddress());
		} else {
			return null;
		}
	}

	@Override
	public String toString()
	{
		String messageComponent = "";
		
		if (message != null) {
			messageComponent = " Message: "  + message;
		} else if (cde != null) {
			messageComponent = " Message: " + cde.getMessage();
		}
		
		String addressComponent = "";
		
		if (addressSet) {
			addressComponent = " Address: 0x" + Long.toHexString(address);
		} else if (this.cde != null && this.cde instanceof AddressedCorruptDataException) {
			addressComponent = " Address: 0x" + Long.toHexString(((AddressedCorruptDataException)cde).getAddress());
		}
		
		return "J9DDRCorruptData [as=" + proc.getAddressSpace() + messageComponent + addressComponent + "]";
	}

	
}
