/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.io;

/**
 * An {@code AutoCloseable} whose close method may throw an {@link IOException}.
 * Closeable 是可以关闭的数据源或目标。调用 close 方法可释放对象保存的资源（如打开文件）。
 */
public interface Closeable extends AutoCloseable {

    /**
     * Closes the object and release any system resources it holds.
     * 关闭此流并释放与此流关联的所有系统资源。
     *
     * <p>Although only the first call has any effect, it is safe to call close
     * multiple times on the same object. This is more lenient than the
     * overridden {@code AutoCloseable.close()}, which may be called at most
     * once.
     */
    void close() throws IOException;
}
