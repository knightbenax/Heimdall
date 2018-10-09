package android.heimdallr.app.heimdallr.databinding;
import android.heimdallr.app.heimdallr.R;
import android.heimdallr.app.heimdallr.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLauncherBindingImpl extends ActivityLauncherBinding implements android.heimdallr.app.heimdallr.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.notch, 8);
        sViewsWithIds.put(R.id.top_panel, 9);
        sViewsWithIds.put(R.id.weather_holder, 10);
        sViewsWithIds.put(R.id.weather_icon, 11);
        sViewsWithIds.put(R.id.weather_tag, 12);
        sViewsWithIds.put(R.id.gesture_holder, 13);
        sViewsWithIds.put(R.id.arrow_up, 14);
        sViewsWithIds.put(R.id.buttons_holder, 15);
        sViewsWithIds.put(R.id.apps_list_holder, 16);
        sViewsWithIds.put(R.id.apps_list_recycler, 17);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLauncherBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private ActivityLauncherBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.LinearLayout) bindings[16]
            , (android.support.v7.widget.RecyclerView) bindings[17]
            , (android.widget.ImageButton) bindings[14]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.ImageButton) bindings[3]
            , (android.support.constraint.ConstraintLayout) bindings[0]
            , (android.widget.ImageButton) bindings[6]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.TextView) bindings[1]
            , (android.view.View) bindings[8]
            , (android.widget.ImageButton) bindings[2]
            , (android.widget.ImageButton) bindings[4]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageButton) bindings[5]
            );
        this.chromeApp.setTag(null);
        this.contactApp.setTag(null);
        this.container.setTag(null);
        this.emailApp.setTag(null);
        this.greetingText.setTag(null);
        this.phoneApp.setTag(null);
        this.smsApp.setTag(null);
        this.whatsApp.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new android.heimdallr.app.heimdallr.generated.callback.OnClickListener(this, 2);
        mCallback1 = new android.heimdallr.app.heimdallr.generated.callback.OnClickListener(this, 1);
        mCallback6 = new android.heimdallr.app.heimdallr.generated.callback.OnClickListener(this, 6);
        mCallback5 = new android.heimdallr.app.heimdallr.generated.callback.OnClickListener(this, 5);
        mCallback4 = new android.heimdallr.app.heimdallr.generated.callback.OnClickListener(this, 4);
        mCallback3 = new android.heimdallr.app.heimdallr.generated.callback.OnClickListener(this, 3);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel Model) {
        updateRegistration(0, Model);
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModel((android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModel(android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel Model, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
        java.lang.String modelGreeting = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (model != null) {
                    // read model.greeting
                    modelGreeting = model.getGreeting();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.chromeApp.setOnClickListener(mCallback6);
            this.contactApp.setOnClickListener(mCallback2);
            this.emailApp.setOnClickListener(mCallback5);
            this.phoneApp.setOnClickListener(mCallback1);
            this.smsApp.setOnClickListener(mCallback3);
            this.whatsApp.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.greetingText, modelGreeting);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // model
                android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
                // model != null
                boolean modelJavaLangObjectNull = false;



                modelJavaLangObjectNull = (model) != (null);
                if (modelJavaLangObjectNull) {



                    model.openContactApp(contactApp);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // model
                android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
                // model != null
                boolean modelJavaLangObjectNull = false;



                modelJavaLangObjectNull = (model) != (null);
                if (modelJavaLangObjectNull) {



                    model.openPhoneApp(phoneApp);
                }
                break;
            }
            case 6: {
                // localize variables for thread safety
                // model
                android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
                // model != null
                boolean modelJavaLangObjectNull = false;



                modelJavaLangObjectNull = (model) != (null);
                if (modelJavaLangObjectNull) {



                    model.openChromeApp(chromeApp);
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // model
                android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
                // model != null
                boolean modelJavaLangObjectNull = false;



                modelJavaLangObjectNull = (model) != (null);
                if (modelJavaLangObjectNull) {



                    model.openEmailApp(emailApp);
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // model
                android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
                // model != null
                boolean modelJavaLangObjectNull = false;



                modelJavaLangObjectNull = (model) != (null);
                if (modelJavaLangObjectNull) {



                    model.openWhatsApp(whatsApp);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // model
                android.heimdallr.app.heimdallr.screens.viewmodels.LauncherActivityViewModel.UIModel model = mModel;
                // model != null
                boolean modelJavaLangObjectNull = false;



                modelJavaLangObjectNull = (model) != (null);
                if (modelJavaLangObjectNull) {



                    model.openSMSApp(smsApp);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}