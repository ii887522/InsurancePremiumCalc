package my.edu.tarc.insurancepremiumcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurancepremiumcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener {
            var basic = 0
            var extra = 0
            var total = 0

            val age = binding.spinnerAge.selectedItemPosition

            when (age) {
                0 -> { // Less than 17
                    basic = 60
                }
                1 -> { // 17 - 25
                    basic = 70
                }
                2 -> { // 26 - 30
                    basic = 90
                }
                3 -> { // 31 - 40
                    basic = 120
                }
                4 -> { // 41 - 55
                    basic = 150
                }
                5 -> { // More than 55
                    basic = 150
                }
            }

            val gender = binding.radioGroupGender.checkedRadioButtonId

            if (gender == binding.radioButtonMale.id) {
                // Calculate extra premium for male
                when (age) {
                    0 -> { // Less than 17
                        extra += 0
                    }
                    1 -> { // 17 - 25
                        extra += 50
                    }
                    2 -> { // 26 - 30
                        extra += 100
                    }
                    3 -> { // 31 - 40
                        extra += 150
                    }
                    4 -> { // 41 - 55
                        extra += 200
                    }
                    5 -> { // More than 55
                        extra += 200
                    }
                }
            }

            val smoker = binding.checkBoxSmoker.isChecked

            if (smoker) {
                // Calculate extra premium for smoker
                when (age) {
                    0 -> { // Less than 17
                        extra += 0
                    }
                    1 -> { // 17 - 25
                        extra += 100
                    }
                    2 -> { // 26 - 30
                        extra += 150
                    }
                    3 -> { // 31 - 40
                        extra += 200
                    }
                    4 -> { // 41 - 55
                        extra += 250
                    }
                    5 -> { // More than 55
                        extra += 300
                    }
                }
            }

            total = basic + extra
            binding.myPremium = Premium(basic, extra, total)
        }

        binding.buttonReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.check(binding.radioButtonMale.id)
            binding.checkBoxSmoker.isChecked = false
            binding.myPremium = Premium()
        }
    }
}