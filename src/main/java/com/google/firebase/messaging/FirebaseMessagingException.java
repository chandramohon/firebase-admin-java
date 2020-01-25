/*
 * Copyright 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.messaging;

import com.google.firebase.ErrorCode;
import com.google.firebase.FirebaseException;
import com.google.firebase.IncomingHttpResponse;
import com.google.firebase.internal.NonNull;
import com.google.firebase.internal.Nullable;

public final class FirebaseMessagingException extends FirebaseException {

  private final MessagingErrorCode errorCode;

  FirebaseMessagingException(
      @NonNull ErrorCode code,
      @NonNull String message,
      @Nullable MessagingErrorCode errorCode,
      @Nullable Throwable cause,
      @Nullable IncomingHttpResponse response) {
    super(code, message, response, cause);
    this.errorCode = errorCode;
  }

  FirebaseMessagingException(@NonNull ErrorCode code, @NonNull String message) {
    this(code, message, null, null, null);
  }

  /** Returns an error code that may provide more information about the error. */
  @Nullable
  public MessagingErrorCode getMessagingErrorCode() {
    return errorCode;
  }
}
