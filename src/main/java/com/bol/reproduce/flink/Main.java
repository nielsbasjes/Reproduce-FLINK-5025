package com.bol.reproduce.flink;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.LocalCollectionOutputFormat;
import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.core.fs.Path;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main implements Serializable {
  public static void main(String[] args) throws Exception {
    System.exit(new Main().run());
  }

  private int run() throws IOException {
    final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

    final DataSet<String> lines =
               env.createInput(new TextInputFormat(new Path("/tmp/doesNotExist")))
        .union(env.createInput(new TextInputFormat(new Path("/tmp/doesNotExist"))))
        .union(env.createInput(new TextInputFormat(new Path("/tmp/doesNotExist"))));

    List<String> allLines = new ArrayList<>();
    lines
      .rebalance()
      .output(new LocalCollectionOutputFormat<>(allLines));

    // execute program
    try {
      env.execute("Running");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
}
