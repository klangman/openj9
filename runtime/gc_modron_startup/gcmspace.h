
/*******************************************************************************
 * Copyright IBM Corp. and others 1991
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

/**
 * @file
 * @ingroup GC_Modron_Startup
 */

#if !defined(GCMSPACE_H_)
#define GCMSPACE_H_

#include "j9.h"
#include "j9comp.h"
#include "MemorySpace.hpp"

class MM_EnvironmentBase;

#ifdef __cplusplus
extern "C" {
#endif

MM_MemorySpace *internalAllocateMemorySpaceWithMaximum(J9JavaVM * javaVM, UDATA minimumSpaceSize, UDATA minimumNewSpaceSize, UDATA initialNewSpaceSize, UDATA maximumNewSpaceSize, UDATA minimumTenureSpaceSize, UDATA initialTenureSpaceSize, UDATA maximumTenureSpaceSize, UDATA memoryMax, UDATA baseAddress, UDATA tenureFlags);
MM_MemorySpace *internalAllocateMemorySpaceWithMaximumWithEnv(MM_EnvironmentBase *env, J9JavaVM *javaVM, UDATA minimumSpaceSize, UDATA minimumNewSpaceSize, UDATA initialNewSpaceSize, UDATA maximumNewSpaceSize, UDATA minimumTenureSpaceSize, UDATA initialTenureSpaceSize, UDATA maximumTenureSpaceSize, UDATA memoryMax, UDATA baseAddress, UDATA tenureFlags);

#ifdef __cplusplus
} /* extern "C" { */
#endif

#endif /* GCMSPACE_H_ */
