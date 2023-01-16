package FarmnCook.FarmnCook;

import lombok.Data;

@Data
public class CommonResponse<T> {

    private boolean success;
    private T data;


    public CommonResponse(boolean success, T data) {
        this.success = success;
        this.data = data;

    }

    public static <T> CommonResponse success(T data) {
        return new CommonResponse<T>(true, data);
    }


}
