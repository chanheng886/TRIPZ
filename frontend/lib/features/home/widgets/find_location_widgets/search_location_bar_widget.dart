import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:get/get.dart';

class SearchLocationBarWidget extends StatelessWidget {
  final TextEditingController searchController;
  final VoidCallback? onBackPressed;
  final ValueChanged<String>? onChanged;
  const SearchLocationBarWidget({
    super.key,
    required this.searchController,
    this.onBackPressed,
    this.onChanged,
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        IconButton(
          onPressed: () {
            if (onBackPressed != null) {
              onBackPressed!();
            } else {
              Get.back();
            }
          },
          icon: FaIcon(FontAwesomeIcons.angleLeft, size: 24),
        ),
        Expanded(
          child: SizedBox(
            height: 50,
            child: ValueListenableBuilder<TextEditingValue>(
              valueListenable: searchController,
              builder: (context, value, child) {
                return TextField(
                  onChanged: onChanged,
                  controller: searchController,
                  textAlignVertical: TextAlignVertical.center,
                  decoration: InputDecoration(
                    prefixIcon: Padding(
                      padding: const EdgeInsets.all(15),
                      child: FaIcon(FontAwesomeIcons.magnifyingGlass, size: 16),
                    ),
                    suffixIcon: value.text.isNotEmpty
                        ? IconButton(
                            onPressed: () => searchController.clear(),
                            icon: FaIcon(FontAwesomeIcons.circleXmark),
                          )
                        : null,
                    enabledBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(30),
                      borderSide: BorderSide(color: Colors.grey.shade500),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(30),
                      borderSide: BorderSide(color: Colors.green.shade400),
                    ),
                    hintText: 'Search locations...',
                    hintStyle: TextStyle(color: Colors.grey),
                  ),
                );
              },
            ),
          ),
        ),
      ],
    );
  }
}
