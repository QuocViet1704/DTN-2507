package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class HinhHoc {
	private static int count = 0;
	private static List<HinhHoc> hinhHoc = new ArrayList<HinhHoc>();

	public HinhHoc() {
		if (count < 5) {
			count++;
			hinhHoc.add(this);
		} else {
			throw new HinhHocException("Số lượng hình tối đa là: " + Config.SO_LUONG_HINH_TOI_DA);
		}
	}

	public double chuVi() {
		return 0;
	}

	public double dienTich() {
		return 0;
	}

	public static List<HinhHoc> getAllHinhHoc() {
		return hinhHoc;
	}
}
