/*
 * This file is provided to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.basho.riak.hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author russell
 * 
 */
public class WordCountResult implements Writable {

    private String word;
    private int count;

    /**
     * @param word
     * @param count
     */
    @JsonCreator public WordCountResult(@JsonProperty("word") String word, @JsonProperty("count") int count) {
        this.word = word;
        this.count = count;
    }

    /**
     * Default CTOR for Hadoop's de-serialization 
     */
    public WordCountResult() {}
    
    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /* (non-Javadoc)
     * @see org.apache.hadoop.io.Writable#readFields(java.io.DataInput)
     */
    public void readFields(DataInput in) throws IOException {
        word = in.readUTF();
        count = in.readInt();
    }

    /* (non-Javadoc)
     * @see org.apache.hadoop.io.Writable#write(java.io.DataOutput)
     */
    public void write(DataOutput out) throws IOException {
        out.writeUTF(word);
        out.write(count);
    }
}
