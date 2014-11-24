/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/freeman/AndroidProject/yanglaolauncher/src/com/dvb/spring/weather/IRemoteService.aidl
 */
package com.dvb.spring.weather;
public interface IRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.dvb.spring.weather.IRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.dvb.spring.weather.IRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.dvb.spring.weather.IRemoteService interface,
 * generating a proxy if needed.
 */
public static com.dvb.spring.weather.IRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.dvb.spring.weather.IRemoteService))) {
return ((com.dvb.spring.weather.IRemoteService)iin);
}
return new com.dvb.spring.weather.IRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getDefaultCity:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDefaultCity();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getDefaultUnit:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getDefaultUnit();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_startGetWeatherInfoTask:
{
data.enforceInterface(DESCRIPTOR);
this.startGetWeatherInfoTask();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.dvb.spring.weather.IRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getDefaultCity() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDefaultCity, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getDefaultUnit() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDefaultUnit, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void startGetWeatherInfoTask() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startGetWeatherInfoTask, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getDefaultCity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getDefaultUnit = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_startGetWeatherInfoTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public java.lang.String getDefaultCity() throws android.os.RemoteException;
public java.lang.String getDefaultUnit() throws android.os.RemoteException;
public void startGetWeatherInfoTask() throws android.os.RemoteException;
}
