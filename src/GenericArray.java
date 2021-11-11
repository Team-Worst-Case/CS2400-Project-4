public final class GenericArray<T>
{
    private Object[] T;

    GenericArray()
    {
        this.T = new Object[1];
    }

    T get(int index)
    {
        return (T) T[index];
    }

    void set(int index, T value)
    {
        T[index] = value;
    }
} 