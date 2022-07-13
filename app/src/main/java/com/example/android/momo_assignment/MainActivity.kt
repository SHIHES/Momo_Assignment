package com.example.android.momo_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android.momo_assignment.databinding.ActivityMainBinding
import com.example.android.momo_assignment.ext.getVmFactory
import com.example.android.momo_assignment.util.CurrentFragmentType
import com.example.android.momo_assignment.util.Logger

class MainActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityMainBinding
    
    private val viewModel by viewModels<MainViewModel>{ getVmFactory() }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        

        
        setupNavController(navController)
        
        viewModel.currentFragmentType.observe(this){
            it?.let {
                when(it){
                    CurrentFragmentType.BUILDING -> {
                        Logger.d("buildingFragment")
                        binding.activityToolbarImage.apply {
                            setImageResource(R.drawable.ic_baseline_arrow_back_24)
                            setOnClickListener {
                                navController.popBackStack()
                            }
                        }
                    }
                    CurrentFragmentType.DETAIL -> {
                        Logger.d("detailFragment")
                        binding.activityToolbarImage.apply {
                            setImageResource(R.drawable.ic_baseline_arrow_back_24)
                            setOnClickListener {
                                navController.popBackStack()
                            }
                        }
                    }
                    CurrentFragmentType.HOME -> {
                        Logger.d("homeFragment")
                        binding.activityToolbarImage.setImageResource(R.drawable.ic_baseline_menu_24)
                        binding.activityToolbarTitle.text = getString(R.string.toolbar_title)
                    }
                }

            }
        }
    }
    
    
    private fun setupNavController(navController: NavController){
        navController.addOnDestinationChangedListener {
            navController: NavController, _:NavDestination, bundle:Bundle? ->
            viewModel.currentFragmentType.value = when (navController.currentDestination?.id) {
                
                R.id.homeFragment -> CurrentFragmentType.HOME
                R.id.buildingFragment -> CurrentFragmentType.BUILDING
                R.id.detailFragment -> CurrentFragmentType.DETAIL
                
                else -> viewModel.currentFragmentType.value

            }
        }
    }
    
    fun setupToolbarTitle(title: String){
        binding.activityToolbarTitle.text = title
    }
}