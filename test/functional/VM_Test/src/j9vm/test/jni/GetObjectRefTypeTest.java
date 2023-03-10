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
/*
 * Created on Nov 7, 2006
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package j9vm.test.jni;

public class GetObjectRefTypeTest {
	public static void main(String[] args) {
		try {
			System.loadLibrary("j9ben");
			if( !getObjectRefTypeTest(new Object()) ) {
				// Throw an exception if we get false back
				System.out.println("**FAILURE** JNI GetObjectRefType not working correctly");
				throw new RuntimeException();
				}
		} catch (UnsatisfiedLinkError e) {
			System.out.println("Problem opening JNI library");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
		
	public static native boolean getObjectRefTypeTest(Object stackArg);
}
