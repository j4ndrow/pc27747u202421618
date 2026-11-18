package com.campuslab.platform.u202421618.shared.application;

/**
 * @author Jose Alejandro Tello Lima
 */
public sealed interface Result<T> permits Result.Success, Result.Failure {
    record Success<T>(T value) implements Result<T> {}
    record Failure<T>(String errorCode) implements Result<T> {}
}
