// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.jetcd.api;

public interface AlarmResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.AlarmResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.etcdserverpb.ResponseHeader header = 1;</code>
   */
  boolean hasHeader();
  /**
   * <code>.etcdserverpb.ResponseHeader header = 1;</code>
   */
  com.coreos.jetcd.api.ResponseHeader getHeader();
  /**
   * <code>.etcdserverpb.ResponseHeader header = 1;</code>
   */
  com.coreos.jetcd.api.ResponseHeaderOrBuilder getHeaderOrBuilder();

  /**
   * <pre>
   * alarms is a list of alarms associated with the alarm request.
   * </pre>
   *
   * <code>repeated .etcdserverpb.AlarmMember alarms = 2;</code>
   */
  java.util.List<AlarmMember>
      getAlarmsList();
  /**
   * <pre>
   * alarms is a list of alarms associated with the alarm request.
   * </pre>
   *
   * <code>repeated .etcdserverpb.AlarmMember alarms = 2;</code>
   */
  AlarmMember getAlarms(int index);
  /**
   * <pre>
   * alarms is a list of alarms associated with the alarm request.
   * </pre>
   *
   * <code>repeated .etcdserverpb.AlarmMember alarms = 2;</code>
   */
  int getAlarmsCount();
  /**
   * <pre>
   * alarms is a list of alarms associated with the alarm request.
   * </pre>
   *
   * <code>repeated .etcdserverpb.AlarmMember alarms = 2;</code>
   */
  java.util.List<? extends AlarmMemberOrBuilder>
      getAlarmsOrBuilderList();
  /**
   * <pre>
   * alarms is a list of alarms associated with the alarm request.
   * </pre>
   *
   * <code>repeated .etcdserverpb.AlarmMember alarms = 2;</code>
   */
  AlarmMemberOrBuilder getAlarmsOrBuilder(
    int index);
}