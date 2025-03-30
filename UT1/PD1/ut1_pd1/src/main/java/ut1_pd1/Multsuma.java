package ut1_pd1;

public class Multsuma {
    float a = 1.0f;
    float b = 2.0f;
    float c = 3.0f;

    public float multsuma(float a, float b, float c) {
        float result;
        result = a * b + c;
        return result;
    }

    public void main(String[] args) {
        System.out.println(multsuma(a, b, c));
    }
}