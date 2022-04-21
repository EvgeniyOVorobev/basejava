import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        size = 0;
        Arrays.fill(storage, 0, size + 2, null);
    }


    void save(Resume r) {
        storage[size] = r;
        size++;

    }

    Resume get(String uuid) {
        for (Resume value : storage) {
            if (value != null) {
                if (uuid.equalsIgnoreCase(value.toString())) {
                    return value;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = null;
                size--;
                for (int j = i; j < size + 1; j++) {
                    storage[j] = storage[j + 1];
                }
            }

        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resume = new Resume[size];
        System.arraycopy(storage, 0, resume, 0, resume.length);


        return resume;
    }

    int size() {
        return size;
    }
}
