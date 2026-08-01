class BusLocation {
  final int id;
  final String locationName;
  final String? imageUrl;

  BusLocation({required this.id, required this.locationName, this.imageUrl});

  factory BusLocation.fromJson(Map<String, dynamic> json) {
    return BusLocation(
      id: json['id'] as int,
      locationName: json['locationName'] as String,
      imageUrl: json['imageUrl'] as String?,
    );
  }
}
