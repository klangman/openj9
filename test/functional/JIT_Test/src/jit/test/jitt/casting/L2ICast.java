/*******************************************************************************
 * Copyright IBM Corp. and others 2001
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
package jit.test.jitt.casting;

import org.testng.annotations.Test;
import org.testng.Assert;

@Test(groups = { "level.sanity","component.jit" })
public class L2ICast extends jit.test.jitt.Test {

	private int tstSimple(long x) {
		return (int)x;
	}

	private int tstComplex(long x) {
		return (int)justReturnIt(x);
	}
	
	private long justReturnIt(long x) {
		return x;
	}

	@Test
	public void testL2ICast() {
		for (int j = 0; j < sJitThreshold; j++) {
			tstSimple(0);
			tstComplex(0);
		}
		if (tstSimple(1L) != (int)1L) Assert.fail("Simple (int)1L incorrect");
		if (tstSimple(-1L) != (int)-1L) Assert.fail("Simple (int)-1L incorrect");
		if (tstSimple(0x0123456789ABCDEFL) != (int)0x0123456789ABCDEFL) Assert.fail("Simple (int)0x0123456789ABCDEFL incorrect");
		if (tstComplex(1L) != (int)1L) Assert.fail("Complex (int)1L incorrect");
		if (tstComplex(-1L) != (int)-1L) Assert.fail("Complex (int)-1L incorrect");
		if (tstComplex(0x0123456789ABCDEFL) != (int)0x0123456789ABCDEFL) Assert.fail("Complex (int)0x0123456789ABCDEFL incorrect");
	}

}
