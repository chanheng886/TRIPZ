import 'dart:convert';
import 'package:frontend/core/constrants/api_constants.dart';
import 'package:frontend/features/home/models/busmodel/bus_location.dart';
import 'package:http/http.dart' as http;

class BusLocationService {
  Future<List<BusLocation>> fetchBusLocation() async {
    final response = await http.get(Uri.parse(ApiConstants.busLocation));

    if (response.statusCode == 200) {
      final List<dynamic> data = jsonDecode(response.body);
      return data.map((json) => BusLocation.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load bus locations');
    }
  }
}
