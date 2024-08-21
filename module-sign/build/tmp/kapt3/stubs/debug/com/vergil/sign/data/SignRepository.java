package com.vergil.sign.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/vergil/sign/data/SignRepository;", "Lcom/vergil/mvvmlazy/base/BaseModel;", "Lcom/vergil/sign/data/source/HttpDataSource;", "Lcom/vergil/sign/data/source/LocalDataSource;", "()V", "mHttpDataSource", "Lcom/vergil/sign/data/source/http/HttpDataSourceImpl;", "getMHttpDataSource", "()Lcom/vergil/sign/data/source/http/HttpDataSourceImpl;", "mHttpDataSource$delegate", "Lkotlin/Lazy;", "mLocalDataSource", "Lcom/vergil/sign/data/source/local/LocalDataSourceImpl;", "getMLocalDataSource", "()Lcom/vergil/sign/data/source/local/LocalDataSourceImpl;", "mLocalDataSource$delegate", "module-sign_debug"})
public final class SignRepository extends com.vergil.mvvmlazy.base.BaseModel implements com.vergil.sign.data.source.HttpDataSource, com.vergil.sign.data.source.LocalDataSource {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mHttpDataSource$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mLocalDataSource$delegate = null;
    
    public SignRepository() {
        super();
    }
    
    private final com.vergil.sign.data.source.http.HttpDataSourceImpl getMHttpDataSource() {
        return null;
    }
    
    private final com.vergil.sign.data.source.local.LocalDataSourceImpl getMLocalDataSource() {
        return null;
    }
}