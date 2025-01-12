package org.sist.erp_project.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Location {
	
	//왜 영어로 저장하는게 관례야 종나 한글 무시하냐
	
    GANGWON("강원"),
    GYEONGGI("경기"),
    GYEONGNAM("경남"),
    GYEONGBUK("경북"),
    GWANGJU("광주"),
    DAEGU("대구"),
    DAEJEON("대전"),
    BUSAN("부산"),
    SEOUL("서울"),
    ULSAN("울산"),
    INCHEON("인천"),
    JEONNAM("전남"),
    JEONBUK("전북"),
    JEJU("제주"),
    CHUNGNAM("충남"),
    CHUNGBUK("충북"),
    OVERSEAS("해외");

    private final String description;

    public static Location fromValue(String value) {
        switch (value) {
            case "1": return GANGWON;
            case "2": return GYEONGGI;
            case "3": return GYEONGNAM;
            case "4": return GYEONGBUK;
            case "5": return GWANGJU;
            case "6": return DAEGU;
            case "7": return DAEJEON;
            case "8": return BUSAN;
            case "9": return SEOUL;
            case "10": return ULSAN;
            case "11": return INCHEON;
            case "12": return JEONNAM;
            case "13": return JEONBUK;
            case "14": return JEJU;
            case "15": return CHUNGNAM;
            case "16": return CHUNGBUK;
            case "17": return OVERSEAS;
            default: throw new IllegalArgumentException("잘못된 위치 값: " + value);
        }
    }
}


