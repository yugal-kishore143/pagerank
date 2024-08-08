package com.example.pagerank;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class SimpleReducer extends Reducer<Text, Text, Text, Text> {

    private Text result = new Text();

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        for (Text val : values) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(val.toString());
        }
        result.set(sb.toString());
        context.write(key, result);
    }
}