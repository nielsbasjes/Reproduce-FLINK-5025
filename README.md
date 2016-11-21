Reproduce optimize bug in Flink
===============================

This is a minimal reproduction project for this bug 
https://issues.apache.org/jira/browse/FLINK-2662
https://issues.apache.org/jira/browse/FLINK-5025

If I run this I see this error on the screen

    org.apache.flink.optimizer.CompilerException: Bug: Plan generation for Unions picked a ship strategy between binary plan operators.
        at org.apache.flink.optimizer.traversals.BinaryUnionReplacer.collect(BinaryUnionReplacer.java:113)
        at org.apache.flink.optimizer.traversals.BinaryUnionReplacer.postVisit(BinaryUnionReplacer.java:72)
        at org.apache.flink.optimizer.traversals.BinaryUnionReplacer.postVisit(BinaryUnionReplacer.java:41)
        at org.apache.flink.optimizer.plan.DualInputPlanNode.accept(DualInputPlanNode.java:170)
        at org.apache.flink.optimizer.plan.SingleInputPlanNode.accept(SingleInputPlanNode.java:199)
        at org.apache.flink.optimizer.plan.SingleInputPlanNode.accept(SingleInputPlanNode.java:199)
        at org.apache.flink.optimizer.plan.OptimizedPlan.accept(OptimizedPlan.java:128)
        at org.apache.flink.optimizer.Optimizer.compile(Optimizer.java:516)
        at org.apache.flink.optimizer.Optimizer.compile(Optimizer.java:398)
        at org.apache.flink.client.LocalExecutor.executePlan(LocalExecutor.java:185)
        at org.apache.flink.api.java.LocalEnvironment.execute(LocalEnvironment.java:91)
        at com.bol.reproduce.flink.Main.run(Main.java:34)
        at com.bol.reproduce.flink.Main.main(Main.java:16)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)

