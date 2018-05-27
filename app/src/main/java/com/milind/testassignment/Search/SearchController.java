package com.milind.testassignment.Search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.milind.testassignment.R;
import com.milind.testassignment.UserSelected.UserSelectController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SearchController extends Controller implements SearchContract.View {


    SearchContract.Presenter presenter;

    @BindView(R.id.button)
    Button btnSearch;
    @BindView(R.id.editText)
    EditText etSearch;
    SearchComponent searchComponent;
    Unbinder unbinder;
    @BindView(R.id.gridView)
    GridView gridView;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {

        View root = inflater.inflate(R.layout.searchandgrid, container, false);


        presenter = new SearchPresenter();
        presenter.attachView(this);
        searchComponent = DaggerSearchComponent.builder()
                .searchModule(new SearchModule(getActivity()))
                .build();

        presenter.attachController(searchComponent);

        unbinder = ButterKnife.bind(this, root);

        return root;
    }



    @OnClick(R.id.button)
    public void onViewClicked() {

        Toast.makeText(getActivity(), " onSearchButtonClick ", Toast.LENGTH_SHORT).show();
        presenter.onSearchButtonClick(etSearch.getText().toString());
    }


    @Override
    public void setGridview(Context context, SearchModel searchModel) {
 gridView.setAdapter(new GridViewAdapter(context,searchModel,this));

    }

    @Override
 public void onImageClick(String url){
        getRouter().pushController(RouterTransaction
                .with(new UserSelectController(url))
                .pushChangeHandler(new FadeChangeHandler())
                .popChangeHandler(new FadeChangeHandler()));
        }
}
