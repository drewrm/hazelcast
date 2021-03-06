/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.concurrent.lock;

import com.hazelcast.concurrent.lock.client.*;
import com.hazelcast.nio.serialization.*;

import java.util.Collection;

public class LockPortableHook implements PortableHook {

    public static final int FACTORY_ID = FactoryIdHelper.getFactoryId(FactoryIdHelper.LOCK_PORTABLE_FACTORY, -15);

    public static final int LOCK = 1;
    public static final int UNLOCK = 2;
    public static final int IS_LOCKED = 3;
    public static final int GET_LOCK_COUNT = 5;
    public static final int GET_REMAINING_LEASE = 6;

    @Override
    public int getFactoryId() {
        return FACTORY_ID;
    }

    @Override
    public PortableFactory createFactory() {
        return new PortableFactory() {
            public Portable create(int classId) {
                switch (classId){
                    case LOCK:
                        return new LockRequest();
                    case UNLOCK:
                        return new UnlockRequest();
                    case IS_LOCKED:
                        return new IsLockedRequest();
                    case GET_LOCK_COUNT:
                        return new GetLockCountRequest();
                    case GET_REMAINING_LEASE:
                        return new GetRemainingLeaseRequest();
                }
                return null;
            }
        };
    }

    @Override
    public Collection<ClassDefinition> getBuiltinDefinitions() {
        return null;
    }
}
