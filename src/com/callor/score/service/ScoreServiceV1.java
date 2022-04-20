package com.callor.score.service;

import com.callor.score.domain.ScoreV2VO;
import com.callor.score.utils.Line;

public class ScoreServiceV1 {
	
	private ScoreV2VO[] scores;
	
	public ScoreServiceV1() {
		this(10);
	}
	
	public ScoreServiceV1(int length) {
		scores = new ScoreV2VO[length];
		for(int i = 0 ; i < scores.length ; i++) {
			scores[i] = new ScoreV2VO();
		}
	}
	
	// 학생 이름 리스트를 배열로 받아서 초기화하기
	public ScoreServiceV1(String[] stNames) {
		
		int length = stNames.length;
		scores = new ScoreV2VO[length];
		for(int i = 0 ; i < length ; i++) {
			scores[i] = new ScoreV2VO();
			scores[i].setStName( stNames[i] );
		}	
	}
	
	public void makeScore() {
		
		for(int i = 0 ; i < scores.length ; i++) {
			int intKor = (int)(Math.random() * 50) + 51;
			int intEng = (int)(Math.random() * 50) + 51;
			int intMath = (int)(Math.random() * 50) + 51;
			
			
			
			scores[i].setIntKor(intKor);
			scores[i].setIntEng(intEng);
			scores[i].setIntMath(intMath);
		}
	
	}
	
	public void printScore() {
		System.out.println(Line.dLine(50));
		System.out.println("빛나고교 성적표");
		System.out.println(Line.sLine(50));
		System.out.println("이 름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(Line.sLine(50));
		
		for(int i = 0 ; i < scores.length ; i++) {
			System.out.print(scores[i].getStName() + "\t");
			System.out.print(scores[i].getIntKor() + "\t");
			System.out.print(scores[i].getIntEng() + "\t");
			System.out.print(scores[i].getIntMath() + "\t");
			System.out.print(scores[i].getIntSum() + "\t");
			System.out.printf("%3.2f\n", scores[i].getfAvg());
			
		}
		System.out.println(Line.sLine(50));
		
	}
	
	// 결과에 각 과목의 총점, 총점의 총점, 평균의 평균 표시하는 코드 추가
	public void scoreSum() {
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		int scoreSum = 0;
		float fSum = 0;
		
		for(int i = 0 ; i < scores.length ; i++) {
			korSum += (int)scores[i].getIntKor();
			engSum += (int)scores[i].getIntEng();
			mathSum += (int)scores[i].getIntMath();
			scoreSum += (int)scores[i].getIntSum();
			fSum += (float)scores[i].getfAvg() / scores.length;
		}
			System.out.printf("총점\t%d\t%d\t%d\t%d\t%3.2f", korSum, engSum, mathSum, scoreSum,fSum);
	}
	
	

}
