package com.easyhome.lbsService;

import com.easyhome.lbsService.po.Coordinate;

public interface LBSService {

	Coordinate getCoordinate(String address, String city);

	double distance(Coordinate coordinate1, Coordinate coordinate2);
}
