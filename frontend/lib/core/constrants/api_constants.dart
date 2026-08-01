class ApiConstants {
  static const String baseUrl = "http://localhost:8080/api/v1";

  static const String busLocation = "$baseUrl/locations";
  // static const String busSchedule =
  //     "$baseUrl/bus-schedule/fromlocation/{fromLocation}/toLocation/{toLocation}/travelDate/{travelDate}";

  static String busSchedule(
    String fromLocation,
    String toLocation,
    String travelDate,
  ) {
    return "$baseUrl/bus-schedule/fromlocation/$fromLocation/toLocation/$toLocation/travelDate/$travelDate";
  }
}
