class BusScheduleModel {
  final int id;
  final String bus;
  final String route;
  final String travelDate;
  final String departureTime;
  final String arrivalTime;
  final int availableSeat;

  BusScheduleModel({
    required this.id,
    required this.bus,
    required this.route,
    required this.travelDate,
    required this.departureTime,
    required this.arrivalTime,
    required this.availableSeat,
  });

  factory BusScheduleModel.fromJson(Map<String, dynamic> json) {
    return BusScheduleModel(
      id: json['id'] as int,
      bus: json['bus'] as String,
      route: json['route'] as String,
      travelDate: json['travelDate'] as String,
      departureTime: json['departureTime'] as String,
      arrivalTime: json['arrivalTime'] as String,
      availableSeat: json['availableSeat'] as int,
    );
  }
}
