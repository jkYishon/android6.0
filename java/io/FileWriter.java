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
 * A specialized {@link Writer} that writes to a file in the file system.
 * All write requests made by calling methods in this class are directly
 * forwarded to the equivalent function of the underlying operating system.
 * Since this may induce some performance penalty, in particular if many small
 * write requests are made, a FileWriter is often wrapped by a
 * BufferedWriter.
 *
 * 用来写入字符文件的便捷类。此类的构造方法假定默认字符编码和默认字节缓冲区大小都是可接受的。
 * 要自己指定这些值，可以先在 FileOutputStream 上构造一个 OutputStreamWriter。
 * 文件是否可用或是否可以被创建取决于底层平台。特别是某些平台一次只允许一个 FileWriter
 *（或其他文件写入对象）打开文件进行写入。在这种情况下，如果所涉及的文件已经打开，则此类中的构造方法将失败。
 * FileWriter 用于写入字符流。要写入原始字节流，请考虑使用 FileOutputStream
 *
 * @see BufferedWriter
 * @see FileReader
 */
public class FileWriter extends OutputStreamWriter {

    /**
     * Creates a FileWriter using the File {@code file}.
     * 根据给定的 File 对象构造一个 FileWriter 对象。
     *
     * @param file
     *            the non-null File to write bytes to.
     *        file - 要写入数据的 File 对象。
     * @throws IOException
     *             if {@code file} cannot be opened for writing.
     *         IOException - 如果该文件存在，但它是一个目录，而不是一个常规文件；
     *             或者该文件不存在，但无法创建它；抑或因为其他某些原因而无法打开它
     */
    public FileWriter(File file) throws IOException {
        super(new FileOutputStream(file));
    }

    /**
     * Creates a FileWriter using the File {@code file}. The parameter
     * {@code append} determines whether or not the file is opened and appended
     * to or just opened and overwritten.
     * 根据给定的 File 对象构造一个 FileWriter 对象。如果第二个参数为 true，则将字节写入文件末尾处，
     * 而不是写入文件开始处。
     *
     * @param file
     *            the non-null File to write bytes to.
     *            file - 要写入数据的 File 对象
     * @param append
     *            indicates whether or not to append to an existing file.
     *        append - 如果为 true，则将字节写入文件末尾处，而不是写入文件开始处
     * @throws IOException
     *             if the {@code file} cannot be opened for writing.
     *         IOException - 如果该文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；
     *         或因为其他某些原因而无法打开它
     */
    public FileWriter(File file, boolean append) throws IOException {
        super(new FileOutputStream(file, append));
    }

    /**
     * Creates a FileWriter using the existing FileDescriptor {@code fd}.
     * 构造与某个文件描述符相关联的 FileWriter 对象。
     *
     * @param fd
     *            the non-null FileDescriptor to write bytes to.
     *            要写入数据的 FileDescriptor 对象。
     */
    public FileWriter(FileDescriptor fd) {
        super(new FileOutputStream(fd));
    }

    /**
     * Creates a FileWriter using the platform dependent {@code filename}.
     * 根据给定的文件名构造一个 FileWriter 对象。
     *
     * @param filename
     *            the non-null name of the file to write bytes to.
     *            一个字符串，表示与系统有关的文件名。
     * @throws IOException
     *             if the file cannot be opened for writing.
     *              如果指定文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；
     *              抑或因为其他某些原因而无法打开它
     */
    public FileWriter(String filename) throws IOException {
        super(new FileOutputStream(new File(filename)));
    }

    /**
     * Creates a FileWriter using the platform dependent {@code filename}. The
     * parameter {@code append} determines whether or not the file is opened and
     * appended to or just opened and overwritten.
     * 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
     *
     * @param filename
     *            the non-null name of the file to write bytes to.
     *              一个字符串，表示与系统有关的文件名。
     * @param append
     *            indicates whether or not to append to an existing file.
     *              一个 boolean 值，如果为 true，则将数据写入文件末尾处，而不是写入文件开始处。
     * @throws IOException
     *             if the {@code file} cannot be opened for writing.
     *              如果指定文件存在，但它是一个目录，而不是一个常规文件；或者该文件不存在，但无法创建它；
     *              抑或因为其他某些原因而无法打开它
     */
    public FileWriter(String filename, boolean append) throws IOException {
        super(new FileOutputStream(filename, append));
    }
}
