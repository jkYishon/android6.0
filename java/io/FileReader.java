/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.io;

/**
 * A specialized {@link Reader} that reads from a file in the file system.
 * All read requests made by calling methods in this class are directly
 * forwarded to the equivalent function of the underlying operating system.
 * Since this may induce some performance penalty, in particular if many small
 * read requests are made, a FileReader is often wrapped by a
 * BufferedReader.
 * 用来读取字符文件的便捷类。此类的构造方法假定默认字符编码和默认字节缓冲区大小都是适当的。要自己指定这些值，
 * 可以先在 FileInputStream 上构造一个 InputStreamReader。
 * FileReader 用于读取字符流。要读取原始字节流，请考虑使用 FileInputStream。
 *
 * @see BufferedReader
 * @see FileWriter
 */
public class FileReader extends InputStreamReader {

    /**
     * Constructs a new FileReader on the given {@code file}.
     * 在给定从中读取数据的 File 的情况下创建一个新 FileReader。
     *
     * @param file
     *            a File to be opened for reading characters from.
     * @throws FileNotFoundException
     *             if {@code file} does not exist.
     */
    public FileReader(File file) throws FileNotFoundException {
        super(new FileInputStream(file));
    }

    /**
     * Construct a new FileReader on the given FileDescriptor {@code fd}. Since
     * a previously opened FileDescriptor is passed as an argument, no
     * FileNotFoundException can be thrown.
     * 在给定从中读取数据的 FileDescriptor 的情况下创建一个新 FileReader。
     *
     * @param fd
     *            the previously opened file descriptor.
     */
    public FileReader(FileDescriptor fd) {
        super(new FileInputStream(fd));
    }

    /**
     * Construct a new FileReader on the given file named {@code filename}.
     * 在给定从中读取数据的文件名的情况下创建一个新 FileReader。
     *
     * @param filename
     *            an absolute or relative path specifying the file to open.
     * @throws FileNotFoundException
     *             if there is no file named {@code filename}.
     */
    public FileReader(String filename) throws FileNotFoundException {
        super(new FileInputStream(filename));
    }
}
