package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
  @Test
  @DisplayName("FirstTest")
  void replace() {
    String actual = "abc".replace("b", "d");
    assertThat(actual).isEqualTo("adc");
  }

  @Test
  void split() {
    String[] actualArray1 = "1,2".split(",");
    assertThat(actualArray1).contains("1", "2");

    String[] actualArray2 = "1,".split(",");
    assertThat(actualArray2).containsExactly("1");

    String actual = "(1,2)";
    String actualArray3 = actual.substring(actual.indexOf("(") + 1, actual.indexOf(")"));
    assertThat(actualArray3).isEqualTo("1,2");
  }

  @Test
  @DisplayName("특정 위치의 문자 가져오기")
  void charAt(){
    String actual = "abc";
    assertThat(actual.charAt(0)).isEqualTo('a');
    assertThat(actual.charAt(1)).isEqualTo('b');
    assertThat(actual.charAt(2)).isEqualTo('c');

    assertThatThrownBy(()->{
     assertThat(actual.charAt(4)).isEqualTo('d');
    }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");
  }
}
