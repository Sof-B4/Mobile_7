package com.example.mobiles4.UI.VM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobiles4.Data.DataSources.List;
import com.example.mobiles4.Data.Repositories.ListRepository;

import com.example.mobiles4.Data.Models.Item;

public class ListViewModel extends ViewModel {
    private MutableLiveData<ListRepository> uiState =
            new MutableLiveData<>(new List());
    private MutableLiveData<ListRepository> uiStateUser =
            new MutableLiveData<>(new List());
    public LiveData<ListRepository> getUiState() {
        return uiState;
    }
    public LiveData<ListRepository> getUiStateUser() {
        return uiStateUser;
    }
    public Item getTask(int index) {
        return uiState.getValue().get(index);
    }
    public void addToList(Item item) {
        uiState.getValue().add(item);
    }


//    public void clearTaskList() {
//        uiState.getValue().clearAll();
//    }
//    public Task createRandomMathematicalTask() {
//        Random random = new Random();
//        Task task;
//        int r = random.nextInt(2);
//        if (r == 0) {
//            task = setRandomArithmeticTask();
//        }
//        else {
//            task = setRandomGeometricTask();
//        }
//        return task;
//    }


//    public void addUserTask(Item item) {
//        uiStateUser.getValue().add(item);
//    }
//    public Item setRandomUserTask() {
//        if (uiStateUser.getValue().isEmpty()) {
//            return createRandomMathematicalTask();
//        }
//        Random random = new Random();
//        Item item = uiStateUser.getValue().get(
//                random.nextInt(uiStateUser.getValue().getSize())
//        );
//        return item;
//    }

//    private Item setRandomArithmeticTask() {
//        Random random = new Random();
//        int image = R.drawable.arithmetic_task;
//        int first = random.nextInt(100);
//        int second = random.nextInt(100);
//        int coperator = random.nextInt(3);
//        Integer answer = 0;
//        String operator = null;
//        switch (coperator) {
//            case 0:
//                operator=" + ";
//                answer = first + second;
//                break;
//            case 1:
//                operator=" - ";
//                answer = first - second;
//                break;
//            case 2:
//                operator=" * ";
//                answer = first * second;
//                break;
//        }
//        String text = "Вычислите: " + first + operator + second;
//        return new Item(text, image, answer.toString());
//    }
//    private Item setRandomGeometricTask() {
//        Random random = new Random();
//        int image = R.drawable.geometry_task;
//        String text = "Чему равен в градусах внутренний\nугол правильного ";
//        int angles = random.nextInt(5);
//        String answer = "none";
//        switch (angles) {
//            case 0:
//                text+="треугольника?";
//                answer = "60";
//                break;
//            case 1:
//                text+="четырёхугольника?";
//                answer = "90";
//                break;
//            case 2:
//                text+="пятиугольника?";
//                answer = "108";
//                break;
//            case 3:
//                text+="шестиугольника?";
//                answer = "120";
//                break;
//            case 4:
//                text+="восьмиугольника?";
//                answer = "135";
//                break;
//        }
//        return new Item(text, image, answer.toString());
//    }
}
