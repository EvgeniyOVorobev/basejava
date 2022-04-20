import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    static int x = 0;

    void clear() {
        x=0;
        Arrays.fill(storage, null);
    }


    void save(Resume r) {
        storage[x] = r;
        x++;

    }

    Resume get(String uuid) {
        Resume resume = new Resume();
        for (Resume value : storage) {
            if (value != null) {
                if (uuid.equalsIgnoreCase(value.toString())) {
                    resume = value;
                    break;
                }
            }

        }

        return resume;
    }

    void delete(String uuid) {
        x--;
        Resume[] resumes = null;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].toString().equals(uuid)) {
                resumes = new Resume[storage.length - 1];
                for (int x = 0; x < i; x++) {
                    resumes[x] = storage[x];
                }
                for (int j = i; j < storage.length - 1; j++) {
                    resumes[j] = storage[j + 1];
                }
                break;
            }
        }
        storage = resumes;


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resume = null;
        int i = 0;
        for (int j = 0; j < storage.length; j++) {
            if (storage[j] != null) {
                i++;
            }

        }
        resume = new Resume[i];
        for (int k = 0; k < resume.length; k++) {
            resume[k] = storage[k];

        }


        return resume;
    }

    int size() {
        Resume resume = new Resume();
        int i = 0;
        for (int j = 0; j < storage.length; j++) {
            if (storage[j] != null)
                i++;
        }
        return i;
    }
}
