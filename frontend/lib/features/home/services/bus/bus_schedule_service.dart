import 'dart:convert';

import 'package:frontend/core/constrants/api_constants.dart';
import 'package:frontend/features/home/models/busmodel/bus_schedule_model.dart';
import 'package:http/http.dart' as http;

class BusScheduleService {
  Future<List<BusScheduleModel>> searchBusSchedule({
    required String fromLocation,
    required String toLocation,
    required String travelDate,
  }) async {
    final url = ApiConstants.busSchedule(fromLocation, toLocation, travelDate);
    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body);
      return data.map((json) => BusScheduleModel.fromJson(json)).toList();
    } else {
      throw Exception('Faild to load bus schedule');
    }
  }
}
