import 'package:frontend/features/home/models/busmodel/bus_location.dart';
import 'package:frontend/features/home/services/bus/bus_location_service.dart';
import 'package:get/get.dart';

class BusLocationViewModel extends GetxController {
  final BusLocationService _service = BusLocationService();

  final RxBool isLoading = false.obs;
  final RxString errorMessage = ''.obs;
  final RxList<BusLocation> allBusLocation = <BusLocation>[].obs;
  final RxList<BusLocation> filteredBusLocation = <BusLocation>[].obs;

  @override
  void onInit() {
    super.onInit();
    fetchBusLocation();
  }

  Future<void> fetchBusLocation() async {
    isLoading.value = true;
    errorMessage.value = '';
    try {
      final result = await _service.fetchBusLocation();
      allBusLocation.value = result;
      filteredBusLocation.value = result;
    } catch (e) {
      errorMessage.value = 'Failed to load bus location: $e';
    } finally {
      isLoading.value = false;
    }
  }

  void searchBusLocation(String query) {
    if (query.isEmpty) {
      filteredBusLocation.value = allBusLocation;
    } else {
      filteredBusLocation.value = allBusLocation
          .where(
            (loc) =>
                loc.locationName.toLowerCase().contains(query.toLowerCase()),
          )
          .toList();
    }
  }
}
