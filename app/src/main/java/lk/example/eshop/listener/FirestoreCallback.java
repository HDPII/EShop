package lk.example.eshop.listener;

public interface FirestoreCallback<T> {
    void onCallback(T data);
}
