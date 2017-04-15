//: net/mindview/util/Null.java
package com.gao.thinking.proxy.util;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface Null {
    class TaskItem<R,C extends Callable<R>> {
  public final Future<R> future;
  public final C task;
  public TaskItem(Future<R> future, C task) {
    this.future = future;
    this.task = task;
  }
} ///:~
} ///:~
