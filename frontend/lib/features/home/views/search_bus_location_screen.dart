import 'package:flutter/material.dart';
import 'package:frontend/features/home/viewmodels/bus_location_view_model.dart';
import 'package:frontend/features/home/widgets/find_location_widgets/search_location_bar_widget.dart';
import 'package:get/get.dart';

class SearchBusLocationScreen extends StatelessWidget {
  final TextEditingController searchLocationController;
  final BusLocationViewModel busLocationViewModel = Get.put(
    BusLocationViewModel(),
  );
  SearchBusLocationScreen({super.key, required this.searchLocationController});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Column(
        children: [
          //✅✅ App bar with back button and search location fields
          Padding(
            padding: const EdgeInsets.only(right: 10, top: 40),
            child: SearchLocationBarWidget(
              searchController: searchLocationController,
            ),
          ),
          Expanded(
            child: Obx(() {
              if (busLocationViewModel.isLoading.value) {
                return Center(child: CircularProgressIndicator());
              }
              if (busLocationViewModel.errorMessage.isNotEmpty) {
                return Center(
                  child: Text(busLocationViewModel.errorMessage.value),
                );
              }
              return ListView.builder(
                itemCount: busLocationViewModel.filteredBusLocation.length,
                itemBuilder: (context, index) {
                  final location =
                      busLocationViewModel.filteredBusLocation[index];
                  return ListTile(
                    title: Text(location.locationName),
                    onTap: () {
                      searchLocationController.text = location.locationName;
                      Get.back();
                    },
                  );
                },
              );
            }),
          ),
        ],
      ),
    );
  }
}
