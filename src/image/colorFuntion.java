package image;

public class colorFuntion {
	colorClass[] color = new colorClass[Type.COLOR_NUMBER];
	int serch(int r,int g,int b) {
		int save = -1;
		int num = 0;
		int save_num = 999999999;
		for(int i = 1; i<Type.COLOR_NUMBER; i++) {
			save = distance(r,g,b,i);
			if(save_num > save) {
				save_num = save;
				num =i;
			}
		}
		return color[num].id;
	}
	int distance(int r,int g,int b,int num ) {
		return (int)Math.round(Math.pow(color[num].r - r,2) + Math.pow(color[num].g - g,2) + Math.pow(color[num].b - b,2));		
	}
	public colorFuntion(){
		color[1] = new colorClass(7,0,124,0);
		color[2] = new colorClass(33,0,217,58);
		color[3] = new colorClass(58,20,180,133);
		color[4] = new colorClass(55,22,126,134);
		color[5] = new colorClass(29,25,25,25);
		color[6] = new colorClass(51,37,22,016);
		color[7] = new colorClass(25,51,76,178);
		color[8] = new colorClass(43,57,41,035);
		color[9] = new colorClass(56,58,142,140);
		color[10] = new colorClass(12,64,64,255);
		color[11] = new colorClass(32,74,128,255);
		color[12] = new colorClass(48,76,50,35);
		color[13] = new colorClass(47,76,62,92);
		color[14] = new colorClass(21,76,76,67);
		color[15] = new colorClass(49,76,82,42);
		color[16] = new colorClass(23,76,127,153);
		color[17] = new colorClass(57,86,44,62);
		color[18] = new colorClass(45,87,92,92);
		color[19] = new colorClass(54,92,25,29);
		color[20] = new colorClass(31,92,219,213);
		color[21] = new colorClass(26,102,76,51);
		color[22] = new colorClass(27,102,127,051);
		color[23] = new colorClass(17,102,153,216);
		color[24] = new colorClass(41,103,117,53);
		color[25] = new colorClass(35,112,2,0);
		color[26] = new colorClass(39,112,108,138);
		color[27] = new colorClass(11,112,112,112);
		color[28] = new colorClass(46,122,73,88);
		color[29] = new colorClass(24,127,63,178);
		color[30] = new colorClass(1,127,178,056);
		color[31] = new colorClass(19,127,204,025);
		color[32] = new colorClass(34,129,86,49);
		color[33] = new colorClass(44,135,107,98);
		color[34] = new colorClass(50,142,60,46);
		color[35] = new colorClass(13,143,119,72);
		color[36] = new colorClass(53,148,63,97);
		color[37] = new colorClass(38,149,87,108);
		color[38] = new colorClass(10,151,109,77);
		color[39] = new colorClass(28,153,51,51);
		color[40] = new colorClass(22,153,153,153);
		color[41] = new colorClass(37,159,82,36);
		color[42] = new colorClass(42,160,77,78);
		color[43] = new colorClass(5,160,160,255);
		color[44] = new colorClass(9,164,168,184);
		color[45] = new colorClass(6,167,167,167);
		color[46] = new colorClass(16,178,76,216);
		color[47] = new colorClass(40,186,133,36);
		color[48] = new colorClass(52,189,48,49);
		color[49] = new colorClass(3,199,199,199);
		color[50] = new colorClass(36,209,167,161);
		color[51] = new colorClass(15,216,127,051);
		color[52] = new colorClass(18,229,229,051);
		color[53] = new colorClass(20,242,127,165);
		color[54] = new colorClass(2,247,233,163);
		color[55] = new colorClass(30,250,238,077);
		color[56] = new colorClass(4,255,0,0);
		color[57] = new colorClass(14,255,252,245);
		color[58] = new colorClass(8,255,255,255);
}
}
