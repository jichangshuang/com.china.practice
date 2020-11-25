import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJava {

    public static void main(String[] args) {

        final String str = "nihao";
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("hello");
                observableEmitter.onNext("www.jichangshaung.com");
                observableEmitter.onNext("let's study!");
                observableEmitter.onNext(str);

            }
        });

        Consumer<String> consumer = new Consumer<String>() {
            public void accept(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + " == consumer  ==" + s);
            }
        };
//        observable.subscribe(consumer);
        observable.observeOn(Schedulers.newThread()).subscribe(consumer);



        Observer<String> observer = new Observer<String>() {
            public void onSubscribe(Disposable disposable) {

            }

            public void onNext(String s) {

            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {

            }
        };

        observable.observeOn(Schedulers.newThread()).subscribe(observer);
    }

}
