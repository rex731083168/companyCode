package com.bruce.json;

import se.akerfeldt.com.google.gson.JsonDeserializer;
import se.akerfeldt.com.google.gson.JsonSerializer;

public abstract class GsonTypeAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T>{

}
