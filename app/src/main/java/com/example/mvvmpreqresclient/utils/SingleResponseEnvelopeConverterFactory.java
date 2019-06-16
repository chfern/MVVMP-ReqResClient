package com.example.mvvmpreqresclient.utils;

import com.example.mvvmpreqresclient.model.SingleResponseEnvelope;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import timber.log.Timber;

class SingleResponseEnvelopeConverterFactory extends Converter.Factory {
    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter (Type type, Annotation[] annotations, Retrofit retrofit) {
        for(Annotation annotation : annotations){
            if(annotation.annotationType() == SingleEnvelopedResponse.class){
                Type envelopedType = TypeToken.getParameterized(SingleResponseEnvelope.class, type).getType();
                final Converter<ResponseBody, SingleResponseEnvelope<?>> delegate = retrofit.nextResponseBodyConverter(this, envelopedType, annotations);
    
                return (Converter<ResponseBody, Object>) value -> {
                    SingleResponseEnvelope<?> envelope = delegate.convert(value);
                    return envelope.getData();
                };
            }
        }
        return null;
    }
    
    public static SingleResponseEnvelopeConverterFactory create(){
        return new SingleResponseEnvelopeConverterFactory();
    }
}
