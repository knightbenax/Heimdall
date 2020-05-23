package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new android.heimdallr.app.heimdallr.DataBinderMapperImpl());
  }
}
