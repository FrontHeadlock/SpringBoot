package umc.Spring.converter;

import umc.Spring.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }
}
