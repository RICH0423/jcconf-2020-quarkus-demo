package com.rich.quarkus;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeBookResourceIT extends BookResourceTest {

    // Execute the same tests but in native mode.
}