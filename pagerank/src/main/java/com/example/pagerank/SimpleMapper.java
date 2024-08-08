package com.example.pagerank;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class SimpleMapper extends Mapper<Object, Text, Text, Text> {

    private Text keyText = new Text();
    private Text valueText = new Text();

    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String[] tokens = value.toString().split("\t");
        if (tokens.length == 2) {
            keyText.set(tokens[0]);
            valueText.set(tokens[1]);
            context.write(keyText, valueText);
        }
    }
}