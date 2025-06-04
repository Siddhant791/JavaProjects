package src.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamsClass<T> {

    private Stream<T> stream;

    // Write a constructor that can take any data type and convert it to a stream
    // how below is a generic constructor that accepts an array of any type T
    public StreamsClass(T[] data) {
        this.stream = Stream.of(data);
    }

    public StreamsClass(T data) {
        this.stream = Stream.of(data);
    }


    public StreamsClass(List<T> list) {
//        this.stream = stream;
        this.stream = list.stream();
    }

    public Stream<T> concatTwoStreams(Stream<T> stream1, Stream<T> stream2) {
        return Stream.concat(stream1, stream2);
    }
}
