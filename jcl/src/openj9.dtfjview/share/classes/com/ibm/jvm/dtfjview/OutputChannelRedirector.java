/*[INCLUDE-IF Sidecar18-SE]*/
/*******************************************************************************
 * Copyright IBM Corp. and others 2012
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
package com.ibm.jvm.dtfjview;

import java.io.PrintStream;

import com.ibm.jvm.dtfjview.spi.IOutputChannel;

/**
 * @author Manqing Li, IBM
 *
 */
public class OutputChannelRedirector implements IOutputChannel {

	private PrintStream redirector;
	
	public OutputChannelRedirector(PrintStream redirector) {
		if (null == redirector) {
			this.redirector = System.out;
		} else {
			this.redirector = redirector;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.jvm.dtfjview.spi.IOutputChannel#print(java.lang.String)
	 */
	public void print(String outputString) {
		redirector.print(outputString);
	}

	/* (non-Javadoc)
	 * @see com.ibm.jvm.dtfjview.spi.IOutputChannel#printPrompt(java.lang.String)
	 */
	public void printPrompt(String prompt) {
		redirector.print(prompt);
	}

	/* (non-Javadoc)
	 * @see com.ibm.jvm.dtfjview.spi.IOutputChannel#println(java.lang.String)
	 */
	public void println(String outputString) {
		redirector.println(outputString);
	}

	/* (non-Javadoc)
	 * @see com.ibm.jvm.dtfjview.spi.IOutputChannel#close()
	 */
	public void close() {
		redirector.close();
	}

	/* (non-Javadoc)
	 * @see com.ibm.jvm.dtfjview.spi.IOutputChannel#flush()
	 */
	public void flush() {
		redirector.flush();
	}

}
