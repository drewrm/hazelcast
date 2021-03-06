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

package com.hazelcast.concurrent.atomiclong;

import com.hazelcast.concurrent.atomiclong.client.AddAndGetRequest;
import com.hazelcast.concurrent.atomiclong.client.AlterAndGetRequest;
import com.hazelcast.concurrent.atomiclong.client.AlterRequest;
import com.hazelcast.concurrent.atomiclong.client.ApplyRequest;
import com.hazelcast.concurrent.atomiclong.client.CompareAndSetRequest;
import com.hazelcast.concurrent.atomiclong.client.GetAndAddRequest;
import com.hazelcast.concurrent.atomiclong.client.GetAndAlterRequest;
import com.hazelcast.concurrent.atomiclong.client.GetAndSetRequest;
import com.hazelcast.concurrent.atomiclong.client.SetRequest;
import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.FactoryIdHelper;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;
import com.hazelcast.nio.serialization.PortableHook;

import java.util.Collection;

public class AtomicLongPortableHook implements PortableHook {

    public static final int F_ID = FactoryIdHelper.getFactoryId(FactoryIdHelper.ATOMIC_LONG_PORTABLE_FACTORY, -17);

    public static final int ADD_AND_GET = 1;
    public static final int COMPARE_AND_SET = 2;
    public static final int GET_AND_ADD = 3;
    public static final int GET_AND_SET = 4;
    public static final int SET = 5;
    public static final int APPLY = 6;
    public static final int ALTER = 7;
    public static final int ALTER_AND_GET = 8;
    public static final int GET_AND_ALTER = 9;

    @Override
    public int getFactoryId() {
        return F_ID;
    }

    @Override
    public PortableFactory createFactory() {
        return new PortableFactory() {
            public Portable create(int classId) {
                switch (classId) {
                    case ADD_AND_GET:
                        return new AddAndGetRequest();
                    case COMPARE_AND_SET:
                        return new CompareAndSetRequest();
                    case GET_AND_ADD:
                        return new GetAndAddRequest();
                    case GET_AND_SET:
                        return new GetAndSetRequest();
                    case SET:
                        return new SetRequest();
                    case APPLY:
                        return new ApplyRequest();
                    case ALTER:
                        return new AlterRequest();
                    case ALTER_AND_GET:
                        return new AlterAndGetRequest();
                    case GET_AND_ALTER:
                        return new GetAndAlterRequest();
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
