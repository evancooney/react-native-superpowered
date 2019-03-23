package com.x86kernel.rnsuperpowered;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public class RNSuperpoweredModule extends ReactContextBaseJavaModule {
  private static ReactApplicationContext _reactContext;

  public RNSuperpoweredModule(ReactApplicationContext reactContext) {
    super(reactContext);
    _reactContext = reactContext;
  }

  public static ReactApplicationContext getReactContextSingleton() {
	  return _reactContext;
  }

  @Override
  public String getName() {
    return "RNSuperpowered";
  }

  @ReactMethod
  public void startRecord(int sampleRate, int minSeconds, int numChannels, boolean applyFade) {
    SuperpoweredRecorder recorder = SuperpoweredRecorder.createInstance();

    if(recorder != null) {
        recorder.start(sampleRate, minSeconds, numChannels, applyFade);
    }
  }

  @ReactMethod
  public void stopRecord(Promise promise) {
  	promise.resolve(SuperpoweredRecorder.getInstance().stop());
  }
}